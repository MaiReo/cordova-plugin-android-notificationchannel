var exec = require('cordova/exec');

var AndroidNotificationChannel = {
	createNotificationChannel: function (channelId, channelName, channelDescription, success, error) {
			cordova.exec(success, error, 'AndroidNotificationChannel', 'createNotificationChannel', [channelId, channelName, channelDescription]);
	},
	AndroidNotificationChannel: undefined
};
AndroidNotificationChannel.AndroidNotificationChannel = AndroidNotificationChannel;
module.exports = AndroidNotificationChannel;
