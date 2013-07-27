package pl.mobiid.shared.datatypes;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Nuclear scenario type with recursive inclusion. Contains Scenario objects for both, true and false, execution condition and 
 * action sets for true condition result and false. 
 * 
 * @author Sebastian
 *
 */
public class Scenario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Warunek
	 */
	private Condition condition;
	/**
	 * Akcja jesli warunek spelniony
	 */
	private ArrayList<Action> trueActionGroup;
	/**
	 * Akcja jesli warunek niespelniony
	 */
	private ArrayList<Action> falseActionGroup;
	/**
	 * Scenariusz jesli warunek spelniony
	 */
	private Scenario nextTrue;	
	/**
	 * Scenariusz jesli warunek niespelniony
	 */
	private Scenario nextFalse;
	
	
	public Scenario() {
		super();
	}
	public Scenario(Condition condition, ArrayList<Action> trueActionGroup, ArrayList<Action> falseActionGroup,
			Scenario nextTrue, Scenario nextFalse) {
		super();
		this.condition = condition;
		this.trueActionGroup = trueActionGroup;
		this.falseActionGroup = falseActionGroup;
		this.nextTrue = nextTrue;
		this.nextFalse = nextFalse;
	}
	/**
	 * @return the condition
	 */
	public Condition getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	/**
	 * @return the trueAction
	 */
	public ArrayList<Action> getTrueActionGroup() {
		return trueActionGroup;
	}
	/**
	 * @param trueAction the trueAction to set
	 */
	public void setTrueActionGroup(ArrayList<Action> trueActionGroup) {
		this.trueActionGroup = trueActionGroup;
	}
	/**
	 * @return the falseAction
	 */
	public ArrayList<Action> getFalseActionGroup() {
		return falseActionGroup;
	}
	/**
	 * @param falseAction the falseAction to set
	 */
	public void setFalseActionGroup(ArrayList<Action> falseActionGroup) {
		this.falseActionGroup = falseActionGroup;
	}
	/**
	 * @return the nextTrue
	 */
	public Scenario getNextTrue() {
		return nextTrue;
	}
	/**
	 * @param nextTrue the nextTrue to set
	 */
	public void setNextTrue(Scenario nextTrue) {
		this.nextTrue = nextTrue;
	}
	/**
	 * @return the nextFalse
	 */
	public Scenario getNextFalse() {
		return nextFalse;
	}
	/**
	 * @param nextFalse the nextFalse to set
	 */
	public void setNextFalse(Scenario nextFalse) {
		this.nextFalse = nextFalse;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Scenario [condition=" + condition + ", trueActionGroup="
				+ trueActionGroup + ", falseActionGroup=" + falseActionGroup
				+ ", nextTrue=" + nextTrue + ", nextFalse=" + nextFalse + "]";
	}
	
	
}
