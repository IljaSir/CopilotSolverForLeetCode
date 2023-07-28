class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res;
        int i = 0;
        while (i < n) {
            if (i == n - 1) {
                res.push_back(nums[i]);
                break;
            }
            if (nums[i] != nums[i + 1]) {
                res.push_back(nums[i]);
                i++;
            } else {
                i += 2;
            }
        }
        return res;
    }
    vector<int> getLonelyNodes(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }
        if (root->left && !root->right) {
            res.push_back(root->left->val);
        }
        if (!root->left && root->right) {
            res.push_back(root->right->val);
        }
        auto left = getLonelyNodes(root->left);
        auto right = getLonelyNodes(root->right);
        res.insert(res.end(), left.begin(), left.end());
        res.insert(res.end(), right.begin(), right.end());
        return res;
    }
    vector<int> getLonelyNodes2(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }
        if (root->left && !root->right) {
            res.push_back(root->left->val);
        }
        if (!root->left && root->right) {
            res.push_back(root->right->val);
        }
        auto left = getLonelyNodes(root->left);
        auto right = getLonelyNodes(root->right);
        res.insert(res.end(), left.begin(), left.end());
        res.insert(res.end(), right.begin(), right.end());
        return res;
    }
    vector<int> getLonelyNodes3(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }
        if (root->left && !root->right) {
            res.push_back(root->left->val);
        }
        if (!root->left && root->right) {
            res.push_back(root->right->val);
        }
        auto left = getLonelyNodes(root->left);
        auto right = getLonelyNodes(root->right);
        res.insert(res.end(), left.begin(), left.end());
        res.insert(res.end(), right.begin(), right.end());
    }
};