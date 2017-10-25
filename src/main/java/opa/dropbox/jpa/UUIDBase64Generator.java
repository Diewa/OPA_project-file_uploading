package opa.dropbox.jpa;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64URLSafeString;

public class UUIDBase64Generator implements IdentifierGenerator {

    private static final int UUID_SIZE_IN_BYTES = 16;

    @Override
    public Serializable generate(SessionImplementor session, Object object) {
        UUID uuid = randomUUID();
        ByteBuffer byteBuffer = ByteBuffer.allocate(UUID_SIZE_IN_BYTES);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return encodeBase64URLSafeString(byteBuffer.array());
    }
}