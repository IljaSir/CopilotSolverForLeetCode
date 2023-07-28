impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut heap = std::collections::BinaryHeap::new();
        for i in 0..piles.len() {
            heap.push(piles[i]);
        }
        let mut k = k;
        while k > 0 {
            let top = heap.pop().unwrap();
            heap.push(top - (top / 2));
            k -= 1;
        }
        heap.into_iter().sum()
    }
}