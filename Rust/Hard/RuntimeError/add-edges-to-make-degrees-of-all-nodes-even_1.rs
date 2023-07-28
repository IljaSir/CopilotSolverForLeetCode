impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let mut graph: Vec<Vec<i32>> = vec![vec![]; n as usize];
        for edge in edges.iter() {
            graph[edge[0] as usize - 1].push(edge[1]);
            graph[edge[1] as usize - 1].push(edge[0]);
        }
        let mut degree: Vec<i32> = vec![0; n as usize];
        for i in 0..n as usize {
            degree[i] = graph[i].len() as i32;
        }
        let mut odd: Vec<i32> = vec![];
        let mut even: Vec<i32> = vec![];
        for i in 0..n as usize {
            if degree[i] % 2 == 0 {
                even.push(i as i32);
            } else {
                odd.push(i as i32);
            }
        }
        if odd.len() == 0 {
            return true;
        }
        if odd.len() % 2 == 1 {
            return false;
        }
        let mut visited: Vec<bool> = vec![false; n as usize];
        let mut queue: Vec<i32> = vec![];
        queue.push(odd[0]);
        visited[odd[0] as usize] = true;
        while queue.len() > 0 {
            let node = queue.remove(0);
            for nei in graph[node as usize].iter() {
                if !visited[*nei as usize - 1] {
                    visited[*nei as usize - 1] = true;
                    queue.push(*nei);
                }
            }
        }
        for i in 0..n as usize {
            if degree[i] % 2 == 1 && !visited[i] {
                return false;
            }
        }
        true
    }
}