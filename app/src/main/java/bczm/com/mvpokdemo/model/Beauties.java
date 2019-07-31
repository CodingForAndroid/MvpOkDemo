package bczm.com.mvpokdemo.model;

import java.util.List;

/**
 * @author zhangjun
 * @date 2019-7-30
 */
public class Beauties {
    /**
     * error : false
     * results : [{"_id":"5927bc01421aa92c79463324","createdAt":"2017-05-26T13:24:17.785Z","desc":"5-26","publishedAt":"2017-05-26T13:43:32.128Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1ffyp4g2vwxj20u00tu77b.jpg","used":true,"who":"daimajia"},{"_id":"5722b27b67765974fbfcf9b9","createdAt":"2016-04-29T09:01:47.962Z","desc":"4.29","publishedAt":"2016-04-29T11:36:42.906Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1f3damign7mj211c0l0dj2.jpg","used":true,"who":"张涵宇"},{"_id":"58ec30e4421aa9544ed88919","createdAt":"2017-04-11T09:27:00.840Z","desc":"4-11","publishedAt":"2017-04-11T14:43:34.738Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-11-17881546_248332202297978_2420944671002853376_n.jpg","used":true,"who":"dmj"},{"_id":"5a4ad432421aa90fe2f02d1a","createdAt":"2018-01-02T08:37:06.235Z","desc":"1-2","publishedAt":"2018-01-02T08:43:32.216Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20180102083655_3t4ytm_Screenshot.jpeg","used":true,"who":"daimajia"},{"_id":"56cc6d22421aa95caa707914","createdAt":"2015-10-12T01:24:51.340Z","desc":"10.12","publishedAt":"2015-10-14T03:19:21.608Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bgw1ewy3cst6rzj20lx0v4wj5.jpg","used":true,"who":"张涵宇"},{"_id":"59a755a2421aa901c85e5fea","createdAt":"2017-08-31T08:17:38.117Z","desc":"8-31","publishedAt":"2017-08-31T08:22:07.982Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fj2ld81qvoj20u00xm0y0.jpg","used":true,"who":"daimajia"},{"_id":"5966c4b8421aa90ca209c452","createdAt":"2017-07-13T08:54:16.862Z","desc":"7-13","publishedAt":"2017-07-13T12:28:15.167Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhhz28n9vyj20u00u00w9.jpg","used":true,"who":"daimajia"},{"_id":"5b15ec20421aa97e45f15aae","createdAt":"2018-06-05T09:49:20.355Z","desc":"2018-06-05","publishedAt":"2018-06-05T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs02a9b0nvj30sg10vk4z.jpg","used":true,"who":"lijinshanmx"},{"_id":"59f7e677421aa90fe72535de","createdAt":"2017-10-31T10:56:55.988Z","desc":"10-31","publishedAt":"2017-10-31T12:25:55.217Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-10-31-nozomisasaki_official_31_10_2017_10_49_17_24.jpg","used":true,"who":"代码家"},{"_id":"57f85461421aa95dd78e8daf","createdAt":"2016-10-08T10:05:21.431Z","desc":"10-8","publishedAt":"2016-10-08T11:42:07.440Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f8kmud15q1j20u011hdjg.jpg","used":true,"who":"daimajia"},{"_id":"5b0d6895421aa97f0308836a","createdAt":"2018-05-29T22:49:57.62Z","desc":"2018-05-30","publishedAt":"2018-05-30T13:22:16.505Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frslibvijrj30k80q678q.jpg","used":true,"who":"lijinshanmx"},{"_id":"575640bf421aa9759750aee4","createdAt":"2016-06-07T11:34:23.596Z","desc":"隐藏福利","publishedAt":"2016-06-07T11:43:18.947Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f4mi70ns1bj20i20vedkh.jpg","used":true,"who":"代码家"},{"_id":"5b1fec10421aa9793930bf99","createdAt":"2018-06-12T23:51:44.815Z","desc":"2018-06-13","publishedAt":"2018-06-14T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs8tym1e8ej30j60ouwhz.jpg","used":true,"who":"lijinshanmx"},{"_id":"57885b8c421aa90de83c1b96","createdAt":"2016-07-15T11:42:04.295Z","desc":"7.15","publishedAt":"2016-07-15T11:56:07.907Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f5ufyzg2ajj20ck0kuq5e.jpg","used":true,"who":"代码家"},{"_id":"5b1e8164421aa910a82cf54f","createdAt":"2018-06-11T22:04:20.9Z","desc":"2018-06-12","publishedAt":"2018-06-12T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1fs7l8ijitfj30jg0shdkc.jpg","used":true,"who":"lijinshanmx"},{"_id":"57b1e41d421aa93a804bea00","createdAt":"2016-08-15T23:47:41.110Z","desc":"816","publishedAt":"2016-08-16T11:22:38.139Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f6uv5gbsa9j20u00qxjt6.jpg","used":true,"who":"代码家"},{"_id":"56cc6d29421aa95caa708266","createdAt":"2016-02-01T13:46:46.600Z","desc":"2.3","publishedAt":"2016-02-03T04:32:45.907Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1f0k6706308j20vg18gqfl.jpg","used":true,"who":"张涵宇"},{"_id":"56d7b07f6776595ac3e5cf92","createdAt":"2016-03-03T11:33:19.706Z","desc":"3.3","publishedAt":"2016-03-03T12:12:56.684Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f1jionqvz6j20hs0qoq7p.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d26421aa95caa707ee3","createdAt":"2015-11-25T02:20:03.201Z","desc":"11.25","publishedAt":"2015-11-25T03:57:07.114Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1eyd07uugyvj20qo0hqgom.jpg","used":true,"who":"张涵宇"},{"_id":"5c6385b39d21225dd7a417ce","createdAt":"2019-02-13T02:49:23.946Z","desc":"2019-02-13","publishedAt":null,"source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5927bc01421aa92c79463324
         * createdAt : 2017-05-26T13:24:17.785Z
         * desc : 5-26
         * publishedAt : 2017-05-26T13:43:32.128Z
         * source : chrome
         * type : 福利
         * url : https://ws1.sinaimg.cn/large/610dc034ly1ffyp4g2vwxj20u00tu77b.jpg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
