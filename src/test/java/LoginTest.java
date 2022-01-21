import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);
    }

    /* @Test(description = "sozdaem account")
     public void createAccount() {
         open("/login");
         $("#inputEmail").sendKeys(email);
         $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
         $(By.id("createButton")).shouldBe(visible);

         $(By.xpath("//input[@name='title']")).sendKeys("NewProject");
         $(By.xpath("//input[@name='code']")).sendKeys("A");
         $(By.xpath("//button[@type='submit']")).click();
         $(By.xpath("}//div[@class='form-control-feedback']")).shouldBe(visible);
     }*/
    @Test(description = "Создаем аккаунт и проверяем ввод данных")
    public void createAccount() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);

        $(By.xpath("//*[@class='btn btn-primary']")).click();
        $(By.xpath("//input[@name='title']")).setValue("A");
        // $(By.xpath("//input[@name='code']")).setValue(" ");
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//div[@class='form-control-feedback']")).shouldBe(visible);
    }

    @Test(description = "Создаем аккаунт и проверяем ввод данных")
    public void createAccount2() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);

        $(By.xpath("//*[@class='btn btn-primary']")).click();
        $(By.xpath("//input[@name='title']")).setValue("Project");
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//span[@class='style_statistic-SjRZY']")).shouldBe(visible);

    }
}
