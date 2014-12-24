App.ApplicationRoute = Ember.Route.extend({
  model: function() {
    return 
	Ember.$.getJSON('https://api.github.com/repos/LearningTree/TicketManorJava/commits').then(function(data) {
      return data.splice(0, 3);
    });
  }
});

