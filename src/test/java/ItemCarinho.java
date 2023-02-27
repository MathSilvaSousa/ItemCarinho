import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class ItemCarinho {
    @Test
    public void adicionarProduto() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver netshoes = new ChromeDriver();
        netshoes.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        netshoes.get("https://www.netshoes.com.br"); // Dia 25/01/2023 Realizado o teste
        netshoes.findElement(By.id("search-input")).sendKeys("camisa seleção brasileira");
        netshoes.findElement(By.className("button")).click();
        netshoes.findElement(By.xpath("/html/body/main/section/section[2]/div[4]/div[1]/a[3]/div/div[1]/div[2]/img")).click();
        netshoes.findElement(By.xpath("/html/body/main/section/section[2]/div[6]/div/div/div/div/div/section/section[2]/section/section[2]/div/ul/li[4]/a")).click();
        netshoes.findElement(By.id("buy-button-now")).click();
        netshoes.get("https://www.netshoes.com.br/cart");
        String item = netshoes.findElement(By.className("name")).getText();
        assertEquals("Camisa Nike Brasil I 2022/23 Torcedor Pro Masculina", item);
        netshoes.quit();
    }
}



