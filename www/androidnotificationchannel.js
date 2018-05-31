var exec = require('cordova/exec');

module.exports = {
	AndroidNotificationChannel: {
		createNotificationChannel: function (channelId, channelName, channelDescription, success, error) {
			cordova.exec(success, error, 'AndroidNotificationChannel', 'createNotificationChannel', [channelId, channelName, channelDescription]);
		}
	}
};
