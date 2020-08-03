package cn.horatio.blogs.entity;

/**
 * @author L-Horatio
 * @date 2020/8/3
 * @time 20:50
 */

/**
 * 电影列表的实体类
 */
public class Movies extends BaseEntity{

    private static final long serialVersionUID = 308647756002475695L;

    private Integer id;
    private Integer uid;
    private String images;
    private String QRCodes;
    private String movies;
    private String type;
    private String level;
    private String description;
    private String download;
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getQRCodes() {
        return QRCodes;
    }

    public void setQRCodes(String QRCodes) {
        this.QRCodes = QRCodes;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", uid=" + uid +
                ", images='" + images + '\'' +
                ", QRCodes='" + QRCodes + '\'' +
                ", movies='" + movies + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", download='" + download + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
