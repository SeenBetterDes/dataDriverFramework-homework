import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class SQLL {


    @org.testng.annotations.Test
    public void test()  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String url = "jbdc:mysql://DESKTOP-3E2NMUA/SQLEXPRESS";
            String user = "Homework";
            String password = "123";
            con = DriverManager.getConnection(url, user, password);

            Statement stm = con.createStatement();
            String query = "select * from student;";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("firstName");
                String Number = rs.getString("lastName");
                String lName = rs.getString("phone");
                System.out.println(name + lName + Number);
                WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
                WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
                WebElement phone = driver.findElement(By.cssSelector("#usernumber"));
                driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[@value='Male']/parent::*\")).click();"));
                firstName.clear();
                lastName.clear();
                phone.clear();

                firstName.sendKeys(name);
                lastName.sendKeys(lName);
                phone.sendKeys(Number);


            }


        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}

