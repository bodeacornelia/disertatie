package com.steps;

import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class CollectionSteps extends GeneralSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void verifyCollectionTitle() {
		String expectedCollectionTitle = (String)Serenity.getCurrentSession().get("collectionTitle");
		String actualCollectionTitle = getCollectionPage().getCollectionTitle();

		Assert.assertTrue("Collection title is not correctly displayed: Expected: " + expectedCollectionTitle
				+ " Actual: " + actualCollectionTitle, expectedCollectionTitle.equals(actualCollectionTitle));
	}
}
