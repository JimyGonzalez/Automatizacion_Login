package starter.login;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoLogin implements Task {

    private final String emailSignIn;
    private final String emailSignInConfirm;

    public DoLogin(String emailSignIn, String emailSignInConfirm) {
        this.emailSignIn = emailSignIn;
        this.emailSignInConfirm = emailSignInConfirm;
    }


    public  static Performable whitCredentials(String emailSignIn, String emailSignInConfirm){
        return instrumented(DoLogin.class, emailSignIn, emailSignInConfirm);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(emailSignIn).into(Loginform.USERNAME_FIELD),
                Enter.theValue(emailSignInConfirm).into(Loginform.PASSWORD_FIELD),
                Click.on(Loginform.LOGIN_BUTTON)

        );
        Thread.sleep(5000);
    }
}
