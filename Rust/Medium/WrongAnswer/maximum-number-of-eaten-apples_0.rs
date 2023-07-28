impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut heap = std::collections::BinaryHeap::new();
        for i in 0..apples.len() {
            if apples[i] > 0 {
                heap.push(std::cmp::Reverse((i as i32 + days[i], apples[i])));
            }
            while let Some(std::cmp::Reverse((day, apple))) = heap.pop() {
                if day > i as i32 {
                    if apple > 1 {
                        heap.push(std::cmp::Reverse((day, apple - 1)));
                    }
                    ans += 1;
                    break;
                }
            }
        }
        let mut i = apples.len() as i32;
        while let Some(std::cmp::Reverse((day, apple))) = heap.pop() {
            if day > i {
                ans += (day - i) as i32;
                i = day;
            }
            if apple > 1 {
                heap.push(std::cmp::Reverse((day, apple - 1)));
            }
            ans += 1;
        }
        ans
    }
}