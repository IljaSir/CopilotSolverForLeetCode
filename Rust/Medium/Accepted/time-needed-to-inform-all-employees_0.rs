impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut graph: Vec<Vec<i32>> = vec![vec![]; n as usize];
        for i in 0..n {
            if manager[i as usize] != -1 {
                graph[manager[i as usize] as usize].push(i);
            }
        }
        let mut max = 0;
        let mut stack: Vec<(i32, i32)> = vec![(head_id, inform_time[head_id as usize])];
        while !stack.is_empty() {
            let (node, time) = stack.pop().unwrap();
            if time > max {
                max = time;
            }
            for child in graph[node as usize].iter() {
                stack.push((*child, time + inform_time[*child as usize]));
            }
        }
        max
    }
}