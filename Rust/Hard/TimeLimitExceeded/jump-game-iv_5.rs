impl Solution {
    pub fn min_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut graph = vec![vec![]; n];
        let mut seen = vec![false; n];
        let mut queue = Vec::new();
        let mut step = 0;
        for i in 0..n {
            if !seen[i] {
                queue.push(i);
                seen[i] = true;
                while !queue.is_empty() {
                    let mut next = Vec::new();
                    for &x in &queue {
                        if x == n - 1 {
                            return step;
                        }
                        graph[x].push(x + 1);
                        if x > 0 {
                            graph[x].push(x - 1);
                        }
                        for j in 0..n {
                            if arr[j] == arr[x] && j != x {
                                graph[x].push(j);
                            }
                        }
                    }
                    for &x in &queue {
                        for &y in &graph[x] {
                            if !seen[y] {
                                next.push(y);
                                seen[y] = true;
                            }
                        }
                    }
                    queue = next;
                    step += 1;
                }
            }
        }
        step
    }
}