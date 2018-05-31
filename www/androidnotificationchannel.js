var exec = require('cordova/exec');

var AndroidNotificationChannel = {
	createNotificationChannel : function (channelId, channelName, channelDescription, success, error) {
		exec(success, error, 'AndroidNotificationChannel', 'createNotificationChannel', [channelId, channelName, channelDescription]);
	},
	AndroidNotificationChannel: AndroidNotificationChannel
};
exports.AndroidNotificationChannel = AndroidNotificationChannel;
