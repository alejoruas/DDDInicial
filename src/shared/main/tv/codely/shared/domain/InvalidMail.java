package tv.codely.shared.domain;

public final class InvalidMail extends DomainError{
    public InvalidMail(String email) {
        super("invalid_email", String.format("Tme email <%s> is invalid", email));
    }
}
