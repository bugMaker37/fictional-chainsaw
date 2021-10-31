import request from '@/utils/request'
const api_name = '/vod/video'

export default {

  getPlayAuth(vid) {
    return request({
      url: `/eduVod/Video/getPlayAuth/${vid}`,
      method: 'get'
    })
  }

}