package project.ljy.rxjavatest.data;

import java.util.List;

/**
 * Title: VideoList
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/3/31
 * Version: 1.0
 */

public class VideoList extends BaseBO {

    private int count;
    private int total;
    private String nextPageUrl;
    private boolean adExist;
    private long date;
    private long nextPublishTime;
    private Object dialog;
    private Object topIssue;
    private int refreshCount;
    private int lastStartId;

    private List<ItemList> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public boolean isAdExist() {
        return adExist;
    }

    public void setAdExist(boolean adExist) {
        this.adExist = adExist;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public Object getTopIssue() {
        return topIssue;
    }

    public void setTopIssue(Object topIssue) {
        this.topIssue = topIssue;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(int refreshCount) {
        this.refreshCount = refreshCount;
    }

    public int getLastStartId() {
        return lastStartId;
    }

    public void setLastStartId(int lastStartId) {
        this.lastStartId = lastStartId;
    }

    public List<ItemList> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }

    public static class ItemList {
        private String type;
        /**
         * dataType : VideoBeanForClient
         * id : 94059
         * title : 如何解除「加班」魔咒？
         * description : 以按时回家为目的的「回家改革部」今日建成，各式招数帮你解除加班魔咒！手段是另一回事，最重要的是要有一个回家的理由啊～让你还未上班就想下班的动力又是什么呢？From KDDI株式会社
         * library : DAILY
         * tags : [{"id":748,"name":"广告精选","actionUrl":"eyepetizer://tag/748/?title=%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT"},{"id":384,"name":"日本广告","actionUrl":"eyepetizer://tag/384/?title=%E6%97%A5%E6%9C%AC%E5%B9%BF%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/1bff9414303805e74affe1954f95d4af.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/40036ba884aed65c07a5ed1525e6cb2a.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"},{"id":146,"name":"666","actionUrl":"eyepetizer://tag/146/?title=666","adTrack":null,"desc":null,"bgPicture":"https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg","headerImage":"http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL"}]
         * consumption : {"collectionCount":96,"shareCount":66,"replyCount":2}
         * resourceType : video
         * slogan : 是什么让你还没上班就想下班？
         * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
         * category : 广告
         * author : {"id":2162,"icon":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","name":"开眼广告精选","description":"为广告人的精彩创意点赞","link":"","latestReleaseTime":1522630800000,"videoNum":902,"adTrack":null,"follow":{"itemType":"author","itemId":2162,"followed":false},"shield":{"itemType":"author","itemId":2162,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true}
         * cover : {"feed":"http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/2f18bf5aaa276c713c2d6d54e6fab536.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=default&source=aliyun
         * thumbPlayUrl : null
         * duration : 132
         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=94059","forWeibo":"http://www.eyepetizer.net/detail.html?vid=94059"}
         * releaseTime : 1522630800000
         * playInfo : [{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun","size":7391877},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=qcloud","size":7391877},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=ucloud","size":7391877}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun"},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=aliyun","size":13630627},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=qcloud","size":13630627},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=ucloud","size":13630627}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=high&source=aliyun"}]
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * type : NORMAL
         * titlePgc : null
         * descriptionPgc : null
         * remark : ビジネス帰宅部｜帰宅スキルを駆使して定時で帰る 「帰り方改革」推進中！
         * ifLimitVideo : false
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1522630800000
         * promotion : null
         * label : null
         * labelList : []
         * descriptionEditor : 以按时回家为目的的「回家改革部」今日建成，各式招数帮你解除加班魔咒！手段是另一回事，最重要的是要有一个回家的理由啊～让你还未上班就想下班的动力又是什么呢？From KDDI株式会社
         * collected : false
         * played : false
         * subtitles : []
         * lastViewTime : null
         * playlists : null
         * src : null
         */

        private Data data;
        private String tag;
        private int id;
        private int adIndex;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public static class Data {
            private String dataType;
            private int id;
            private String title;
            private String description;
            private String library;
            /**
             * collectionCount : 96
             * shareCount : 66
             * replyCount : 2
             */

            private Consumption consumption;
            private String resourceType;
            private String slogan;
            /**
             * name : YouTube
             * alias : youtube
             * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
             */

            private Provider provider;
            private String category;
            /**
             * id : 2162
             * icon : http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg
             * name : 开眼广告精选
             * description : 为广告人的精彩创意点赞
             * link :
             * latestReleaseTime : 1522630800000
             * videoNum : 902
             * adTrack : null
             * follow : {"itemType":"author","itemId":2162,"followed":false}
             * shield : {"itemType":"author","itemId":2162,"shielded":false}
             * approvedNotReadyVideoCount : 0
             * ifPgc : true
             */

            private Author author;
            /**
             * feed : http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageMogr2/quality/60/format/jpg
             * blurred : http://img.kaiyanapp.com/2f18bf5aaa276c713c2d6d54e6fab536.jpeg?imageMogr2/quality/60/format/jpg
             * sharing : null
             * homepage : http://img.kaiyanapp.com/d628bcf2315af0fb6dac0ec063f1dac2.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
             */

            private Cover cover;
            private String playUrl;
            private Object thumbPlayUrl;
            private int duration;
            /**
             * raw : http://www.eyepetizer.net/detail.html?vid=94059
             * forWeibo : http://www.eyepetizer.net/detail.html?vid=94059
             */

            private WebUrl webUrl;
            private long releaseTime;
            private Object campaign;
            private Object waterMarks;
            private Object adTrack;
            private String type;
            private Object titlePgc;
            private Object descriptionPgc;
            private String remark;
            private boolean ifLimitVideo;
            private int idx;
            private Object shareAdTrack;
            private Object favoriteAdTrack;
            private Object webAdTrack;
            private long date;
            private Object promotion;
            private Object label;
            private String descriptionEditor;
            private boolean collected;
            private boolean played;
            private Object lastViewTime;
            private Object playlists;
            private Object src;
            /**
             * id : 748
             * name : 广告精选
             * actionUrl : eyepetizer://tag/748/?title=%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89
             * adTrack : null
             * desc : null
             * bgPicture : http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg
             * headerImage : http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg
             * tagRecType : IMPORTANT
             */

            private List<Tags> tags;
            /**
             * height : 480
             * width : 854
             * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun","size":7391877},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=qcloud","size":7391877},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=ucloud","size":7391877}]
             * name : 标清
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun
             */

            private List<PlayInfo> playInfo;
            private List<?> labelList;
            private List<?> subtitles;

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLibrary() {
                return library;
            }

            public void setLibrary(String library) {
                this.library = library;
            }

            public Consumption getConsumption() {
                return consumption;
            }

            public void setConsumption(Consumption consumption) {
                this.consumption = consumption;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public Provider getProvider() {
                return provider;
            }

            public void setProvider(Provider provider) {
                this.provider = provider;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public Author getAuthor() {
                return author;
            }

            public void setAuthor(Author author) {
                this.author = author;
            }

            public Cover getCover() {
                return cover;
            }

            public void setCover(Cover cover) {
                this.cover = cover;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public Object getThumbPlayUrl() {
                return thumbPlayUrl;
            }

            public void setThumbPlayUrl(Object thumbPlayUrl) {
                this.thumbPlayUrl = thumbPlayUrl;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public WebUrl getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(WebUrl webUrl) {
                this.webUrl = webUrl;
            }

            public long getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
            }

            public Object getCampaign() {
                return campaign;
            }

            public void setCampaign(Object campaign) {
                this.campaign = campaign;
            }

            public Object getWaterMarks() {
                return waterMarks;
            }

            public void setWaterMarks(Object waterMarks) {
                this.waterMarks = waterMarks;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getTitlePgc() {
                return titlePgc;
            }

            public void setTitlePgc(Object titlePgc) {
                this.titlePgc = titlePgc;
            }

            public Object getDescriptionPgc() {
                return descriptionPgc;
            }

            public void setDescriptionPgc(Object descriptionPgc) {
                this.descriptionPgc = descriptionPgc;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public boolean isIfLimitVideo() {
                return ifLimitVideo;
            }

            public void setIfLimitVideo(boolean ifLimitVideo) {
                this.ifLimitVideo = ifLimitVideo;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public Object getShareAdTrack() {
                return shareAdTrack;
            }

            public void setShareAdTrack(Object shareAdTrack) {
                this.shareAdTrack = shareAdTrack;
            }

            public Object getFavoriteAdTrack() {
                return favoriteAdTrack;
            }

            public void setFavoriteAdTrack(Object favoriteAdTrack) {
                this.favoriteAdTrack = favoriteAdTrack;
            }

            public Object getWebAdTrack() {
                return webAdTrack;
            }

            public void setWebAdTrack(Object webAdTrack) {
                this.webAdTrack = webAdTrack;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public Object getPromotion() {
                return promotion;
            }

            public void setPromotion(Object promotion) {
                this.promotion = promotion;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getDescriptionEditor() {
                return descriptionEditor;
            }

            public void setDescriptionEditor(String descriptionEditor) {
                this.descriptionEditor = descriptionEditor;
            }

            public boolean isCollected() {
                return collected;
            }

            public void setCollected(boolean collected) {
                this.collected = collected;
            }

            public boolean isPlayed() {
                return played;
            }

            public void setPlayed(boolean played) {
                this.played = played;
            }

            public Object getLastViewTime() {
                return lastViewTime;
            }

            public void setLastViewTime(Object lastViewTime) {
                this.lastViewTime = lastViewTime;
            }

            public Object getPlaylists() {
                return playlists;
            }

            public void setPlaylists(Object playlists) {
                this.playlists = playlists;
            }

            public Object getSrc() {
                return src;
            }

            public void setSrc(Object src) {
                this.src = src;
            }

            public List<Tags> getTags() {
                return tags;
            }

            public void setTags(List<Tags> tags) {
                this.tags = tags;
            }

            public List<PlayInfo> getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(List<PlayInfo> playInfo) {
                this.playInfo = playInfo;
            }

            public List<?> getLabelList() {
                return labelList;
            }

            public void setLabelList(List<?> labelList) {
                this.labelList = labelList;
            }

            public List<?> getSubtitles() {
                return subtitles;
            }

            public void setSubtitles(List<?> subtitles) {
                this.subtitles = subtitles;
            }

            public static class Consumption {
                private int collectionCount;
                private int shareCount;
                private int replyCount;

                public int getCollectionCount() {
                    return collectionCount;
                }

                public void setCollectionCount(int collectionCount) {
                    this.collectionCount = collectionCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }

            public static class Provider {
                private String name;
                private String alias;
                private String icon;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAlias() {
                    return alias;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }
            }

            public static class Author {
                private int id;
                private String icon;
                private String name;
                private String description;
                private String link;
                private long latestReleaseTime;
                private int videoNum;
                private Object adTrack;
                /**
                 * itemType : author
                 * itemId : 2162
                 * followed : false
                 */

                private Follow follow;
                /**
                 * itemType : author
                 * itemId : 2162
                 * shielded : false
                 */

                private Shield shield;
                private int approvedNotReadyVideoCount;
                private boolean ifPgc;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public long getLatestReleaseTime() {
                    return latestReleaseTime;
                }

                public void setLatestReleaseTime(long latestReleaseTime) {
                    this.latestReleaseTime = latestReleaseTime;
                }

                public int getVideoNum() {
                    return videoNum;
                }

                public void setVideoNum(int videoNum) {
                    this.videoNum = videoNum;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public Follow getFollow() {
                    return follow;
                }

                public void setFollow(Follow follow) {
                    this.follow = follow;
                }

                public Shield getShield() {
                    return shield;
                }

                public void setShield(Shield shield) {
                    this.shield = shield;
                }

                public int getApprovedNotReadyVideoCount() {
                    return approvedNotReadyVideoCount;
                }

                public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                    this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                }

                public boolean isIfPgc() {
                    return ifPgc;
                }

                public void setIfPgc(boolean ifPgc) {
                    this.ifPgc = ifPgc;
                }

                public static class Follow {
                    private String itemType;
                    private int itemId;
                    private boolean followed;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isFollowed() {
                        return followed;
                    }

                    public void setFollowed(boolean followed) {
                        this.followed = followed;
                    }
                }

                public static class Shield {
                    private String itemType;
                    private int itemId;
                    private boolean shielded;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isShielded() {
                        return shielded;
                    }

                    public void setShielded(boolean shielded) {
                        this.shielded = shielded;
                    }
                }
            }

            public static class Cover {
                private String feed;
                private String detail;
                private String blurred;
                private Object sharing;
                private String homepage;

                public String getFeed() {
                    return feed;
                }

                public void setFeed(String feed) {
                    this.feed = feed;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getBlurred() {
                    return blurred;
                }

                public void setBlurred(String blurred) {
                    this.blurred = blurred;
                }

                public Object getSharing() {
                    return sharing;
                }

                public void setSharing(Object sharing) {
                    this.sharing = sharing;
                }

                public String getHomepage() {
                    return homepage;
                }

                public void setHomepage(String homepage) {
                    this.homepage = homepage;
                }
            }

            public static class WebUrl {
                private String raw;
                private String forWeibo;

                public String getRaw() {
                    return raw;
                }

                public void setRaw(String raw) {
                    this.raw = raw;
                }

                public String getForWeibo() {
                    return forWeibo;
                }

                public void setForWeibo(String forWeibo) {
                    this.forWeibo = forWeibo;
                }
            }

            public static class Tags {
                private int id;
                private String name;
                private String actionUrl;
                private Object adTrack;
                private Object desc;
                private String bgPicture;
                private String headerImage;
                private String tagRecType;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public Object getDesc() {
                    return desc;
                }

                public void setDesc(Object desc) {
                    this.desc = desc;
                }

                public String getBgPicture() {
                    return bgPicture;
                }

                public void setBgPicture(String bgPicture) {
                    this.bgPicture = bgPicture;
                }

                public String getHeaderImage() {
                    return headerImage;
                }

                public void setHeaderImage(String headerImage) {
                    this.headerImage = headerImage;
                }

                public String getTagRecType() {
                    return tagRecType;
                }

                public void setTagRecType(String tagRecType) {
                    this.tagRecType = tagRecType;
                }
            }

            public static class PlayInfo {
                private int height;
                private int width;
                private String name;
                private String type;
                private String url;
                /**
                 * name : aliyun
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=94059&editionType=normal&source=aliyun
                 * size : 7391877
                 */

                private List<UrlList> urlList;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<UrlList> getUrlList() {
                    return urlList;
                }

                public void setUrlList(List<UrlList> urlList) {
                    this.urlList = urlList;
                }

                public static class UrlList {
                    private String name;
                    private String url;
                    private int size;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }
                }
            }
        }
    }
}
