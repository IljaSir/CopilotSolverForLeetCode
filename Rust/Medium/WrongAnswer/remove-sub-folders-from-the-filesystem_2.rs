impl Solution {
    pub fn remove_subfolders(folder: Vec<String>) -> Vec<String> {
        
        let mut folder = folder;
        folder.sort();
        let mut ans = vec![folder[0].clone()];
        for i in 1..folder.len() {
            let mut j = 0;
            while j < ans.len() {
                if ans[j].len() < folder[i].len() && ans[j] == &folder[i][0..ans[j].len()] && folder[i].chars().nth(ans[j].len()).unwrap() == '/' {
                    ans.remove(j);
                } else {
                    j += 1;
                }
            }
            ans.push(folder[i].clone());
        }
        ans
    }
}