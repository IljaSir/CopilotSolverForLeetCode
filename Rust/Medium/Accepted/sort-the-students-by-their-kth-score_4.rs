impl Solution {
    pub fn sort_the_students(score: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut score = score;
        let k = k as usize;
        score.sort_by_key(|x| x[k]);
        score.reverse();
        score
    }
}