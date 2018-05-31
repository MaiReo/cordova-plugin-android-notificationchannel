var exec = require('cordova/exec');

exports.exports = {
	AndroidNotificationChannel: {
		createNotificationChannel: function (channelId, channelName, channelDescription, success, error) {
			cordova.exec(success, error, 'AndroidNotificationChannel', 'createNotificationChannel', [channelId, channelName, channelDescription]);
		}
	}
};
