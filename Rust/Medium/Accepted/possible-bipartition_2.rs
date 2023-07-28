impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for dislike in dislikes {
            let (a, b) = (dislike[0] as usize - 1, dislike[1] as usize - 1);
            graph[a].push(b);
            graph[b].push(a);
        }
        let mut colors = vec![0; n];
        for i in 0..n {
            if colors[i] == 0 && !Self::dfs(i, &mut colors, &graph, 1) {
                return false;
            }
        }
        true
    }
    fn dfs(i: usize, colors: &mut Vec<i32>, graph: &Vec<Vec<usize>>, color: i32) -> bool {
        if colors[i] != 0 {
            return colors[i] == color;
        }
        colors[i] = color;
        for &j in &graph[i] {
            if !Self::dfs(j, colors, graph, -color) {
                return false;
            }
        }
        true
    }
}