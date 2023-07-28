impl Solution {
    pub fn get_order(tasks: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut tasks = tasks;
        tasks.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut heap = BinaryHeap::new();
        let mut time = tasks[0][0];
        let mut i = 0;
        let mut res = vec![];
        while i < tasks.len() || !heap.is_empty() {
            while i < tasks.len() && tasks[i][0] <= time {
                heap.push(Reverse((tasks[i][1], i as i32)));
                i += 1;
            }
            if let Some(Reverse((_, idx))) = heap.pop() {
                res.push(idx);
                time += tasks[idx as usize][1];
            } else {
                time = tasks[i][0];
            }
        }
        res
    }
}