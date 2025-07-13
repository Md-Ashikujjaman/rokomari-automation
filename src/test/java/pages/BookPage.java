package pages;

import org.openqa.selenium.By;

public class BookPage extends HomePage{

    public String url = "https://www.rokomari.com/book";
    public By bookMenu = By.xpath("//div[@id='ts--desktop-menu']/div/a/span[text()='বই']");
    public By authorMenu = By.xpath("//span[contains(text(),'লেখক')]");
    public By authorHumayunAhmed =By.xpath("(//a[contains(text(),'হুমায়ূন আহমেদ')])");
    public By inStockBooks = By.xpath("//input[@id='instock']");
    public By byPublishers = By.xpath("//p[contains(text(),'By Publishers')]");
    public By categoriesContemporaryNovel = By.xpath("//label[contains(text(),'সমকালীন উপন্যাস')]");
    public By paginationElement = By.xpath("//div[@class='pagination']");
    public By paginationRight = By.xpath("//i[@class='ion-chevron-right']");
    public By bookMane = By.xpath("//div[@title='শুভ্র গেছে বনে হুমায়ূন আহমেদ']");
    public By addToCard = By.xpath("(//button[contains(text(),'Add to Cart')])[1]");
    public By cardMenu = By.xpath("//a[@id='js-cart-menu']");


}
