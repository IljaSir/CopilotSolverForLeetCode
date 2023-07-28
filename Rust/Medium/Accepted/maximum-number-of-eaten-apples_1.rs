impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut heap = std::collections::BinaryHeap::new();
        let mut ret = 0;
        for i in 0..apples.len() {
            if apples[i] > 0 {
                heap.push((-(i as i32 + days[i]), apples[i]));
            }
            while !heap.is_empty() {
                let (day, n) = heap.pop().unwrap();
                let day = -day;
                if day > i as i32 {
                    if n > 1 {
                        heap.push((-(day), n - 1));
                    }
                    ret += 1;
                    break;
                }
            }
        }
        let mut i = apples.len() as i32;
        while !heap.is_empty() {
            let (day, n) = heap.pop().unwrap();
            let day = -day;
            let eat = std::cmp::min(n, day - i);
            ret += eat;
            i += eat;
        }
        ret
    }
}