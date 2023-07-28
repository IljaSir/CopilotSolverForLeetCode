impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for i in 0..dominoes.len() {
            for j in (i+1)..dominoes.len() {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    count += 1;
                }
            }
        }
        count
    }
}