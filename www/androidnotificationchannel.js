var exec = require('cordova/exec');

exports.createNotificationChannel = function (channelId, channelName, channelDescription, success, error) {
    exec(success, error, 'androidnotificationchannel', 'createNotificationChannel', [channelId, channelName, channelDescription]);
};
