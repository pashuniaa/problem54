# problem54
POKER GAME -> COMPARES EACH PLAYER'S HAND OF CARD AND DETERMINES WHO HAS STRONGER ONE    

HOW THE SOLUTION WORKS:
    
FileParser class scans the poker.txt file and creates a new Map<String, List<Hand>> which contains two Strings as keys (firstPlayerHands, secondPlayerHands).
Each key has a List<Hand> of all scanned card rows. 

Later on the Comparator class runs a loop through all off our player's hands, and on each player's hand it call's a Hand class method getHandRank(List<Card> playerHandCards),
passing in the list of Card objects extracted from our Hand object. The method returns a map consisting only of 1 key and value. The key is our hand's rank(enum), and the
value is a List<Integer> of our 5 card object values, converted to integer and sorted in an ascending order for the convenience. We will use that list of integers when
the first player's hand is the same as the second player's one, in that case the program will loop through each player's list of integers, comparing the elements for the 
High Card. Once again, if both values at the highest index are equal, it descends to the lower index and checks again. 

For every superior Rank or a High Card, the program increases player's PlayerScore counter by 1. 
Then it prints out both players score.

TRICKY PARTS:

I unexpectedly spent way too much time trying to figure out the way to sort our hand's cards by their value. I wanted to create a separate list for every card value, 
and put all of those lists inside another data structure. For example, if Hand Rank would be Four Of A Kind, the program would create only 2 lists, first one containing 
one card (QD), and the second one containing 4 cards of the same value (KS, KD, KC, KH). The solution that I have stumbled upon uses streams and collectors.

That way I don't have to use embedded for loops, instead one line of code:
Map<String, List<Card>> map= playerHandCards.stream().collect(Collectors.groupingBy(Card::getCardRank));

WHAT I WOULD CHANGE IN MY CODE:

I would create enums for card object variables Suit and Value. That wouldn't add much, but I think the code would be more versatile when expanding this project to the full
poker game. The reason why I haven't done that is that the only times when I have used those variables is when initiating a new Card object. For example the Rank enum was 
needed because I have used it's values to check the rank's superiority, and it really improves code readability.   
