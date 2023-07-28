impl Solution {
    pub fn remove_subfolders(folder: Vec<String>) -> Vec<String> {
        
        let mut folder = folder;
        folder.sort();
        let mut ans = Vec::new();
        let mut last = "/".to_string();
        for f in folder {
            if !f.starts_with(&last) {
                ans.push(f.clone());
                last = f + "/";
            }
        }
        ans
    }
}