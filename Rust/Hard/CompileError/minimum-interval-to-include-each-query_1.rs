impl Solution {
    pub fn min_interval(intervals: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut intervals = intervals;
        let mut queries = queries;
        intervals.sort_unstable_by_key(|x| x[0]);
        queries.sort_unstable();
        let mut ans = vec![-1; queries.len()];
        let mut heap = std::collections::BinaryHeap::new();
        let mut i = 0;
        for q in queries {
            while i < intervals.len() && intervals[i][0] <= q {
                heap.push(std::cmp::Reverse(intervals[i][1] - intervals[i][0] + 1));
                i += 1;
            }
            while let Some(std::cmp::Reverse(x)) = heap.peek() {
                if *x < q {
                    heap.pop();
                } else {
                    break;
                }
            }
            if let Some(std::cmp::Reverse(x)) = heap.peek() {
                ans[queries.binary_search(&q).unwrap()] = *x;
            }
        }
        ans
    }
}