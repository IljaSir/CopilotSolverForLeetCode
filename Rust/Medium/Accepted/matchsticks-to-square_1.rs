impl Solution {
    pub fn makesquare(matchsticks: Vec<i32>) -> bool {
        

        if matchsticks.len() < 4 {
            return false;
        }
        let sum = matchsticks.iter().sum::<i32>();
        if sum % 4 != 0 {
            return false;
        }
        let target = sum / 4;
        let mut matchsticks = matchsticks;
        matchsticks.sort();
        let mut visited = vec![false; matchsticks.len()];
        return Self::dfs(&matchsticks, &mut visited, target, 0, 0, 0);
    }

    fn dfs(matchsticks: &Vec<i32>, visited: &mut Vec<bool>, target: i32, index: usize, side: i32, k: i32) -> bool {
        if k == 3 {
            return true;
        }
        if side == target {
            return Self::dfs(matchsticks, visited, target, 0, 0, k + 1);
        }
        for i in index..matchsticks.len() {
            if visited[i] {
                continue;
            }
            if side + matchsticks[i] > target {
                break;
            }
            visited[i] = true;
            if Self::dfs(matchsticks, visited, target, i + 1, side + matchsticks[i], k) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}