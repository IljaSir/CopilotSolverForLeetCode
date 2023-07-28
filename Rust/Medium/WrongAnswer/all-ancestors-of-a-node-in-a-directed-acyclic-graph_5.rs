impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![vec![]; n as usize];
        let mut map = vec![vec![]; n as usize];
        for e in edges {
            map[e[0] as usize].push(e[1]);
        }
        for i in 0..n {
            Self::dfs(i, &mut ans, &map);
        }
        ans
    }
    fn dfs(i: i32, ans: &mut Vec<Vec<i32>>, map: &Vec<Vec<i32>>) {
        for j in map[i as usize].iter() {
            ans[*j as usize].push(i);
            Self::dfs(*j, ans, map);
        }
    }
}