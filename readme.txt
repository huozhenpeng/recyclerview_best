###点击事件位置


###统计广告


###预取功能

      linearLayoutManager.setItemPrefetchEnabled(true);
      这个值默认是打开的
      收益参考：https://blog.csdn.net/crazy_everyday_xrp/article/details/70344638



###Recyclerview嵌套Recyclerview时覆写setInitialPrefetchItemCount

       比如说在一个Recyclerview中有的item也是一个Recyclerview（可以横着滚动的Recyclerview）

       用户滑动到横向滑动的item RecyclerView的时候，由于需要创建更复杂的RecyclerView以及多个子view,可能会导致页面卡顿
       由于RenderThread的存在，RecyclerView会进行prefetch
       LinearLayoutManager.setInitialPrefetchItemCount(横向列表初次显示可见的item个数)
       -- 只有LinearLayoutManager有这个API
       -- 只有潜逃在内部的RecyclerView才会生效.


###RecyclerView setHasFixedSize(true)

       true if adapter changes cannot affect the size of the RecyclerView.
       比如说item是由一张图片和一个textview组成的，如果textview没有限制行数，那么有时候textview可能是一行有时候可能是两行，这时候
       就不能设置为true了


###多个Recyclerview共用RecyclerviewPool

       如果多个Recyclerview中的item的布局都是一样的，可以共用一个RecyclerviewPool

       RecyclerView automatically creates a pool for itself if you don't provide one.


###DiffUtil







