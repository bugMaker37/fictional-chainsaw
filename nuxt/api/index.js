import request from '@/utils/request'
export default {
  getList() {
    return request({
      url: `/eduservice/indexFront/index`,
      method: 'get'
    })
  }
}