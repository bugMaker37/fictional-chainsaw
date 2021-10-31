import request from '@/utils/request'

export default {
  //用户注册
  register(formItem) {
    return request({
      url: `/educenter/member/register`,
      method: 'post',
      data: formItem
    })
  }
}