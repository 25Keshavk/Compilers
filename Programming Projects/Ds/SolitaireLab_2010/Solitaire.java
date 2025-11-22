import java.util.*;
/**
 * Class of Solitare, follows the rules of Solitaire and creates a functional
 * Solitaire game for the user to play.
 *
 * @author Keshav Kotamraju
 * @version November 2, 2023
 */
public class Solitaire
{
	public static void main(String[] args)
	{
		new Solitaire();
	}

	private Stack<Card> stock;
	private Stack<Card> waste;
	private Stack<Card>[] foundations;
	private Stack<Card>[] piles;
	private SolitaireDisplay display;
	/**
	 * Constructor for class of Solitaire, creates piles, which are stacks for cards
	 */
	public Solitaire()
	{
		foundations = new Stack[4];
		piles = new Stack[7];
		stock = new Stack<Card>();
		waste = new Stack<Card>();
		display = new SolitaireDisplay(this);
		for (int i = 0; i<foundations.length; i++)
		{
			foundations[i] = new Stack();
		}
		for (int i = 0; i<piles.length; i++)
		{
			piles[i] = new Stack();
		}
		createStock();
		deal();
	}

	/**
	 * Gets the card on top of the stock, or null if the stock is empty
	 *
	 * @return null if the stock is empty, stock.peek() otherwise
	 *
	 */
	public Card getStockCard()
	{
		if (stock.isEmpty())
			return null;
		return stock.peek();
	}


	/**
	 * Returns the card on top of the waste, or null if the waste is empty
	 *
	 * @return null if the waste is empty, the card on top of the waste
	 *
	 */
	public Card getWasteCard()
	{
		if (waste.isEmpty())
			return null;
		return waste.peek();
	}
	/**
	 * Returns the card on top of the foundation, or null if the foundation is
	 empty
	 *
	 * @param index the index of the foundation
	 *
	 * @return null if the foundation is empty, top card of the foundation otherwise
	 *
	 */
	public Card getFoundationCard(int index)
	{
		if (foundations[index] == null || foundations[index].isEmpty())
			return null;
		return foundations[index].peek();
	}

	/**
     * Gets the pile at a specific index
     * @param index the index of the pile
     *
	 * @return the pile desired
     */
	public Stack<Card> getPile(int index)
	{
		return piles[index];
	}

	/**
	 * Called when the stock is clicked, moves three cards to the waste or
	 resets the stock
	 */
	public void stockClicked()
	{
		if(!display.isWasteSelected() && !display.isPileSelected())
		{
			if (!stock.isEmpty())
			{
				dealThreeCards();
			}
			else
			{
				resetStock();
			}
		}

	}

	/**
	 * Called when the waste is clicked, selects or unselects the waste
	 */
	public void wasteClicked()
	{
		if (!waste.isEmpty() && !display.isWasteSelected() && !display.isPileSelected())
		{
			display.selectWaste();
		}
		else
			display.unselect();
	}

	/**
	 * Called when the foundation is clicked, pushes cards onto the foundation if possible
	 *
	 * @param index the index of the foundation
	 */
	public void foundationClicked(int index)
	{
		if (display.isWasteSelected())
		{
			if (canAddToFoundation(waste.peek(),index))
			{
				foundations[index].push(waste.pop());
			}
		}
		if (display.isPileSelected())
		{
			if (canAddToFoundation(piles[display.selectedPile()].peek(),index))
			{
				foundations[index].push(piles[display.selectedPile()].pop());
			}
		}
		display.unselect();
		System.out.println("foundation #" + index + " clicked");
	}

	/**
	 * Called when the pile is clicked, performs various functions based on
	 what is selected and the contents of certain stacks
	 *
	 * @param index the index of the pile clicked
	 *
	 */
	public void pileClicked(int index)
	{
		if (display.isWasteSelected() && canAddToPile(waste.peek(),index))
		{
			piles[index].push(waste.pop());
			display.unselect();
		}
		else if (display.isPileSelected())
		{
			if (display.selectedPile() == index)
			{
				display.unselect();
				//
			}
			else
			{
				Stack<Card> removed = removeFaceUpCards(display.selectedPile());
				if (canAddToPile(removed.peek(),index))
				{
					display.unselect();
					addToPile(removed,index);
				}
				else
				{

					addToPile(removed,display.selectedPile());
					display.unselect();
				}
			}
		}
		else if (!display.isWasteSelected() && !display.isPileSelected())
		{
			if (!piles[index].isEmpty())
			{
				Card card = piles[index].peek();
				card.turnUp();
				//
			}
			if (piles[index].peek().isFaceUp())
			{
				display.selectPile(index);
			}
		}
	}
	/**
	 * Creates a stock of cards, with cards of each number from every suit
	 */
	public void createStock()
	{
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int i = 1; i<14; i++)
		{
			deck.add(new Card(i,"c"));
			deck.add(new Card(i,"d"));
			deck.add(new Card(i,"h"));
			deck.add(new Card(i,"s"));
		}
		int originalSize = deck.size();
		for (int i = 0 ; i<originalSize; i++)
		{
			int randomIndex = (int)(Math.random()*deck.size());
			stock.add(deck.remove(randomIndex));
		}
	}
	/**
	 * Deals the cards to the piles
	 */
	public void deal()
	{
		for (int i = 0; i<7; i++)
		{
			for (int j = i; j<7; j++)
			{
				piles[j].add(stock.pop());
			}
			piles[i].peek().turnUp();
		}
	}
	/**
	 * Moves the three top cards from the stock to the waste, turning them face up,
	 * if there aren't three cards left in the stock removes whatever remains.
	 */
	public void dealThreeCards()
	{
		for (int i = 0; i<3; i++)
		{
			if (stock.peek() != null)
			{
				waste.push(stock.pop());
				waste.peek().turnUp();
			}
		}
	}
	/**
	 * Resets the stock by moving cards from the waste to the stock
	 */
	public void resetStock()
	{
		while (waste.peek() != null)
		{
			stock.push(waste.pop());
			stock.peek().turnDown();
		}
	}
	/**
	 * Tests if a card can be added to a specific pile
	 *
	 * @param card the card to be added
	 * @param index the index of the pile
	 *
	 * @return true if the card can be added;
	 *         otherwise, false
	 */
	private boolean canAddToPile(Card card, int index)
	{
		if (piles[index].isEmpty())
		{
			if (card.getRank() == 13)
				return true;
			return false;
		}
		else
		{
			Card top = piles[index].peek();
			if (card.getRank() == top.getRank()-1 && (card.isRed() != top.isRed()))
			{
				return true;
			}
			return false;
		}
	}
	/**
	 * Removes the face up cards in a pile and returns a stack of the removed cards
	 *
	 * @param index the index of the pile
	 *
	 * @return the removed stack containing the face up cards
	 */
	private Stack<Card> removeFaceUpCards(int index)
	{
		Stack<Card>  stk = new Stack<Card>();
		while (!piles[index].isEmpty() && piles[index].peek().isFaceUp())
		{
			stk.push(piles[index].pop());
		}
		return stk;
	}
	/**
	 * Adds a stack of cards to a specific pile
	 *
	 * @param cards the stack of cards to be added
	 * @param index the index of the pile
	 *
	 */
	private void addToPile(Stack<Card> cards, int index)
	{
		while (!cards.isEmpty())
		{
			piles[index].push(cards.pop());
		}
	}
	/**
	 * Tests if a card can be added to a specific foundation
	 *
	 * @param card the card to be added
	 * @param index the index of the foundation
	 *
	 * @return true if the card can be added;
	 *         otherwise, false
	 */
	private boolean canAddToFoundation(Card card, int index)
	{
		if (foundations[index].isEmpty())
		{
			if (card.getRank() == 1)
				return true;
			return false;
		}
		Card front = foundations[index].peek();
		if (card.getSuit() == front.getSuit() && front.getRank()+1 == card.getRank())
		{
			return true;
		}
		return false;
	}

	/**
	 * Helper method that checks if the top card of the pile double clicked
	 * can be added to the foundation.  If it can, the card is added
	 *
	 * @param index the index of the pile
	 */

	public void foundPileClicked(int index)
	{
		int num = canAddToFoundations(piles[display.selectedPile()].peek());
			if (num != -1)
			{
				foundations[num].push(piles[display.selectedPile()].pop());
			}

		display.unselect();
	}
	/**
	 * Helper method that checks if the top card of the waste double clicked
	 * can be added to the foundation. If it can, the card is added.
	 */
	public void foundWasteClicked()
	{
		int num = canAddToFoundations(waste.peek());
		if (num != -1)
		{
			foundations[num].push(waste.pop());
		}

		display.unselect();
	}
	/**
	 * Helper method that checks if the card given can be added to foundation
	 *
	 * @return the index of the foundation to add to
	 */
	private int canAddToFoundations(Card card)
	{
		for (int i = 0; i < 4; i++)
		{
			if (!foundations[i].isEmpty())
			{
				Card front = foundations[i].peek();
				if (card.getSuit() == front.getSuit() && front.getRank() + 1 == card.getRank())
				{
				return i;
				}
			}
		}
		for (int i = 0; i < 4 ; i++)
		{
			if (foundations[i].isEmpty())
			{
				if (card.getRank() == 1)
					return i;
			}
		}

		return -1;
	}


}