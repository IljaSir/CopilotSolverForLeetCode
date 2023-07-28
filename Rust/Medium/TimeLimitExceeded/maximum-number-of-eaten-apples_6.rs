impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut days = days.into_iter().zip(apples.into_iter()).collect::<Vec<_>>();
        days.sort_by_key(|x| x.0);
        let mut i = 0;
        let mut j = 0;
        let mut pq = std::collections::BinaryHeap::new();
        while i < days.len() || !pq.is_empty() {
            if i < days.len() && days[i].0 == j {
                pq.push(days[i].1);
                i += 1;
            }
            if !pq.is_empty() {
                let mut top = pq.pop().unwrap();
                if top > 0 {
                    res += 1;
                    top -= 1;
                    if top > 0 {
                        pq.push(top);
                    }
                }
            }
            j += 1;
        }
        res
    }
}