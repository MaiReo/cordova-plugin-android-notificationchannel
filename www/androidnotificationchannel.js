var exec = require('cordova/exec');

var androidNotificationChannel = {
	createNotificationChannel : function (channelId, channelName, channelDescription, success, error) {
		exec(success, error, 'NotificationChannelPlugin', 'createNotificationChannel', [channelId, channelName, channelDescription]);
	}
};
exports.androidNotificationChannel = androidNotificationChannel;
