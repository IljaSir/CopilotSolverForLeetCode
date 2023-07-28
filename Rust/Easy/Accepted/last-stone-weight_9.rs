impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        
        let mut heap = stones;
        heap.sort_unstable();
        loop {
            let n = heap.len();
            if n == 0 {
                return 0;
            } else if n == 1 {
                return heap[0];
            }
            let x = heap.pop().unwrap();
            let y = heap.pop().unwrap();
            if x == y {
                continue;
            } else {
                let z = x - y;
                let mut i = 0;
                while i < n - 2 && heap[i] < z {
                    i += 1;
                }
                heap.insert(i, z);
            }
        }
    }
}