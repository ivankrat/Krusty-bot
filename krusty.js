const discord = require('discord.js');
const client = new Discord.Client();

client.on('ready', () => {
  console.log('I am ready!');
});

client.on('message', message => {
  if(message.content === 'KY online') {
    message.reply('*Krusty wobbles at you*');
  }
});

client.login(process.env.BOT_TOKEN);
