package tests;



import org.testng.Assert;
import org.testng.annotations.*;
import retry.BootsnippRetry;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
/*
public class BootsnipTest extends BasicTest{

    @Test(priority = 1, retryAnalyzer = BootsnippRetry.class)
    public void verifyPageIsOpened() {
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com ",
                "Erroe message");

    }

    @Test(priority = 2, retryAnalyzer = BootsnippRetry.class)
    public void deleteRow() {
        int rowNumberBeforeDelete = tablePage.getVisibleRowNumber();

        tablePage.clickOnDeleteButtonByRowIndex(0);
        deleteDialogPage.waitForDialogToBeVisible();
        Assert.assertEquals(
               deleteDialogPage.getDialogBodyMessage(),
               "Are you sure you want to delete this data?",
               "Delete dialog message is not valid.");

        deleteDialogPage.clickOnDeleteButton();
        deleteDialogPage.waitForDialogToBeInvisible();

        int rowNumberAfterDelete = tablePage.getVisibleRowNumber();

        Assert.assertEquals(
                rowNumberAfterDelete,
                rowNumberBeforeDelete - 1,
                "Row should be deleted");
    }*/



