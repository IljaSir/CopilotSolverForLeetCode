impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut tree = vec![vec![]; n as usize];
        for i in 0..n {
            let m = manager[i as usize];
            if m != -1 {
                tree[m as usize].push(i);
            }
        }
        let mut max = 0;
        let mut stack = vec![(head_id, 0)];
        while let Some((node, time)) = stack.pop() {
            let time = time + inform_time[node as usize];
            if time > max {
                max = time;
            }
            for child in &tree[node as usize] {
                stack.push((*child, time));
            }
        }
        max
    }
}