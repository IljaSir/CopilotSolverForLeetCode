impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut apples = apples.iter().zip(days.iter()).collect::<Vec<_>>();
        apples.sort_by_key(|&x| x.1);
        let mut heap = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut ans = 0;
        for d in 0.. {
            while i < apples.len() && apples[i].1 <= &d {
                i += 1;
            }
            for j in i..apples.len() {
                heap.push(std::cmp::Reverse((d + apples[j].1, apples[j].0)));
            }
            while let Some(std::cmp::Reverse((expire, apple))) = heap.pop() {
                if expire > d {
                    ans += 1;
                    if apple > 1 {
                        heap.push(std::cmp::Reverse((expire, apple - 1)));
                    }
                    break;
                }
            }
            if i == apples.len() && heap.is_empty() {
                break;
            }
        }
        ans
    }
}