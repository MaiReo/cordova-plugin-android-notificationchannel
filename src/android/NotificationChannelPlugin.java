package bid.maireo.android.notification;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationChannelPlugin extends CordovaPlugin {

    private INotificationChannelHelper _notificationChannelHelper;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView){
        super.initialize(cordova, webView);
        this._notificationChannelHelper = new NotificationChannelHelper(cordova);
    }

    /**
     * Executes the request.
     *
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return                Whether the action was valid.
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action == null) return  false;
        if (action.isEmpty()) return  false;
        boolean isSucceed = false;
        switch (action.toLowerCase()){
            case  "createnotificationchannel":
                isSucceed = createNotificationChannel(args, callbackContext);
                break;
            default:
                break;
        }
        sendNoResultPluginResult(callbackContext);
        return isSucceed;
    }

    private void sendNoResultPluginResult(CallbackContext callbackContext) {
        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
    }

    private boolean createNotificationChannel(final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (args == null) return  false;
        if (args.length()< 1) return  false;
        if (args == null) return  false;
        if (args.length()< 1) return  false;
        String channelId  =  args.getString(0);
        if (channelId == null) return  false;
        channelId = channelId.trim();
        if (channelId.isEmpty()) return  false;
        String channelName = null;
        if(args.length() > 1) channelName =  args.getString(1);
        if (channelName == null) return  false;
        channelName = channelName.trim();
        if (channelName.isEmpty()) return  false;
        String channelDescription  =  null;
        if (args.length()> 2) channelDescription = args.getString(2);
        boolean isSucceed =  _notificationChannelHelper.createChannel(channelId, channelName, channelDescription);
        if(isSucceed) {
            JSONObject successJsonObject = new JSONObject();
            successJsonObject.put("channelId",channelId);
            successJsonObject.put("channelName",channelName);
            successJsonObject.put("channelDescription",channelDescription);
            callbackContext.success(successJsonObject);
        }else {
            JSONObject errorJsonObject = new JSONObject();
            errorJsonObject.put("channelId",channelId);
            errorJsonObject.put("channelName",channelName);
            errorJsonObject.put("channelDescription",channelDescription);
            callbackContext.error(errorJsonObject);
        }
        return  isSucceed;
    }
}
