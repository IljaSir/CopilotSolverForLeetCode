impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let mut graph: Vec<Vec<i32>> = vec![vec![]; n as usize];
        for dislike in dislikes {
            graph[dislike[0] as usize - 1].push(dislike[1] - 1);
            graph[dislike[1] as usize - 1].push(dislike[0] - 1);
        }
        let mut color: Vec<i32> = vec![-1; n as usize];
        for i in 0..n {
            if color[i as usize] == -1 && !Solution::dfs(i, &mut color, &graph) {
                return false;
            }
        }
        true
    }
    fn dfs(node: i32, color: &mut Vec<i32>, graph: &Vec<Vec<i32>>) -> bool {
        color[node as usize] = 1;
        for &v in &graph[node as usize] {
            if color[v as usize] == -1 {
                color[v as usize] = 0;
                if !Solution::dfs(v, color, graph) {
                    return false;
                }
            } else if color[v as usize] == color[node as usize] {
                return false;
            }
        }
        true
    }
}