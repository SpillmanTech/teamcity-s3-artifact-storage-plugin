package jetbrains.buildServer.artifacts;

import com.google.gson.Gson;
import jetbrains.buildServer.artifacts.s3.S3Constants;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Nikita.Skvortsov
 * date: 24.03.2016.
 */
@Test
public class TestS3ArtifactSerialization {
  public void testSerializeDeserialize() {

    Gson gson = new Gson();
    final ExternalArtifact a = new ExternalArtifact("http://some.url", "my/relative/path with spaces", 100L, S3Constants.S3_PATH_PREFIX_ATTR, "fakeKey", S3Constants.S3_BUCKET_NAME, "bucket.name");
    final ExternalArtifact b = gson.fromJson(gson.toJson(a), ExternalArtifact.class);

    assertThat(b).isEqualToComparingFieldByField(a);
  }
}
