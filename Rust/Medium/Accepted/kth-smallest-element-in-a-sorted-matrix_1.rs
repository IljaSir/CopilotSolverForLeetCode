impl Solution {
    pub fn kth_smallest(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        

        let k = k as usize;
        let mut heap = std::collections::BinaryHeap::new();
        for row in matrix {
            for item in row {
                heap.push(item);
                if heap.len() > k {
                    heap.pop();
                }
            }
        }
        heap.pop().unwrap()
    }
}