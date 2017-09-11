package io.ushi.springboot.domain.mybatis;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by zhouleibo on 2017/9/11.
 */
public class Document implements Serializable {

    private Long id;

    private String groupId;

    private String artifactId;

    private String version;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("groupId", groupId)
                .add("artifactId", artifactId)
                .add("version", version)
                .toString();
    }
}
