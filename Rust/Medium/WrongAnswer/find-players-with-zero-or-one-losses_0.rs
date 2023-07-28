impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut winners = std::collections::HashSet::new();
        let mut losers = std::collections::HashSet::new();
        for m in matches {
            winners.insert(m[0]);
            losers.insert(m[1]);
        }
        let mut answer = Vec::new();
        answer.push(winners.iter().filter(|x| !losers.contains(x)).map(|x| *x).collect());
        answer.push(losers.iter().filter(|x| !winners.contains(x)).map(|x| *x).collect());
        answer
    }
}