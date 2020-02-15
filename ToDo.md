## To Do   
   
   What questions to answer (examples from in28minutes.webdriver.basics 1)
   
   * [] Multibrowsers 
   * [] CssSelection
   
        * testCssSelectorForMultipleTableTd() {	
driver.findElement(By.cssSelector("#dataTables-example > tbody > tr:nth-child(1) > td:nth-child(2)"));
driver.findElement(By.cssSelector("#dataTables-example > tbody > tr:nth-child(2) > td:nth-child(2)"));
driver.findElement(By.cssSelector("#dataTables-example > tbody > tr:nth-child(3) > td:nth-child(2)"));

WebElement tableTbody = driver.findElement(By.cssSelector("#dataTables-example > tbody"));
WebElement browserRow1 = tableTbody.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)"));
WebElement browserRow2 = tableTbody.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)"));
WebElement browserRow3 = tableTbody.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)"));
   
   * [] XPath

	    * public void testXpathSelectorForaTableTd() {
	driver.get("http://localhost:8080/pages/tables.html");
		//$x("//*[@id='dataTables-example']/tbody/tr[1]/td[2]")
		WebElement browserRow1 = driver.findElement(By.xpath("//*[@id='dataTables-example']/tbody/tr[1]/td[2]"));
		assertEquals(browserRow1.getText(), "Firefox 1.0");		
	}
	
    //	$$("#dataTables-example > thead > tr > th:nth-child(2)")
    //	[th.sorting]0: th.sortinglength: 1__proto__: Array(0)
    //	$$("#dataTables-example > tbody > tr.gradeU.odd > td.sorting_1")
    //	[td.sorting_1]
	
	    * public void testXpathSelectorForSortingAndCheckingFirstRow() {
		
    //	$x("//*[@id='dataTables-example']/thead/tr/th[2]")
    //	[th.sorting]0: th.sortinglength: 1__proto__: Array(0)
    //	$x("//*[@id='dataTables-example']/tbody/tr[1]/td[2]")
    //	[td]
				
		driver.get("http://localhost:8080/pages/tables.html");
		WebElement headerBrowser = driver.findElement(By.xpath("//*[@id='dataTables-example']/thead/tr/th[2]"));
		headerBrowser.click();
		WebElement element = driver.findElement(By.xpath("//*[@id='dataTables-example']/tbody/tr[1]/td[2]"));
		assertEquals(element.getText(), "All others");		
	    }