impl Solution {
    pub fn get_order(tasks: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut tasks = tasks
            .into_iter()
            .enumerate()
            .map(|(i, t)| (t[0], t[1], i as i32))
            .collect::<Vec<_>>();
        tasks.sort();
        let mut ans = Vec::new();
        let mut idle = 0;
        let mut heap = std::collections::BinaryHeap::new();
        for (e, p, i) in tasks {
            if e <= idle {
                heap.push((-(p as i32), -i));
            } else {
                while !heap.is_empty() {
                    let (p, i) = heap.pop().unwrap();
                    ans.push(-i);
                    idle += -p;
                }
                idle = e + p;
                ans.push(i);
            }
        }
        while !heap.is_empty() {
            let (p, i) = heap.pop().unwrap();
            ans.push(-i);
            idle += -p;
        }
        ans
    }
}